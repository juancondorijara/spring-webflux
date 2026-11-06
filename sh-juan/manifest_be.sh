#!/bin/bash
# DAR PERMISOS
# ✅chmod +x manifest_be.sh

# EJECUTAR EL .SH
# ✅./manifest_be.sh


# ✅ Crear el directorio 'be' si no existe
mkdir -p be

# ✅ 1. Namespace
cat << 'EOF' > be/juan-condori-00-namespace.yml
# kubectl create namespace juan-condori-00-namespace (COMANDO)
# kubectl apply -f juan-condori-00-namespace.yml (yml)
# kubectl delete -f juan-condori-00-namespace.yml (yml)
apiVersion: v1
kind: Namespace
metadata:
  name: juan-condori-00-namespace
EOF

# ✅ 2. Secret
cat << 'EOF' > be/juan-condori-00-secret.yml
# kubectl apply -f juan-condori-00-secret.yml
# kubectl delete -f juan-condori-00-secret.yml
apiVersion: v1
kind: Secret
metadata:
  name: juan-condori-00-secret
  namespace: juan-condori-00-namespace
type: Opaque
data:
  MONGO_DATABASE: ZGF0YWJhc2VfY2xvdWQ=   # en Base64
  MONGO_URI: bW9uZ29kYitzcnY6Ly9qdWFuOjEyMzQ1QGNsdXN0ZXIwLnpkbDluLm1vbmdvZGIubmV0Lz9hcHBOYW1lPUNsdXN0ZXIw   # en Base64
  SERVER_PORT: ODA4MQ==
EOF

# ✅ 3. Deployment
cat << 'EOF' > be/juan-condori-00-deployment.yml
# kubectl apply -f juan-condori-00-deployment.yml
# kubectl delete -f juan-condori-00-deployment.yml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: juan-condori-00-deployment
  namespace: juan-condori-00-namespace
spec:
  replicas: 2
  selector:
    matchLabels:
      app: juan-condori-00-deployment        # Debe coincidir con las etiquetas del Service
  template:
    metadata:
      labels:
        app: juan-condori-00-deployment      # Debe coincidir con las etiquetas del Service
    spec:
      containers:
      - name: juan-condori-00-container
        image: juan321/springwebflux-mongodb:1.0   # Reemplaza con tu imagen Docker Hub
        imagePullPolicy: Always        # IfNotPresent | Always Evitar traer siempre la última versión si hay una actual
        envFrom:
        - secretRef:
            name: juan-condori-00-secret  # Esto cargará todos los valores del Secret como variables de entorno
        #- configMapRef:
        #    name: juan-condori-00-configmap # Esto cargará todos los valores del ConfigMap como variables de entorno
EOF

# ✅ 4. Service
cat << 'EOF' > be/juan-condori-00-service.yml
# kubectl apply -f juan-condori-00-service.yml
# kubectl delete -f juan-condori-00-service.yml
apiVersion: v1
kind: Service
metadata:
  name: juan-condori-00-service
  namespace: juan-condori-00-namespace
spec:
  type: NodePort      #30000-32767  # Cambia a LoadBalancer si estás en un entorno de nube
  ports:
  - port: 30001       # Puerto que el Service expondrá
    targetPort: 8081  # Puerto en el contenedor donde tu aplicación escucha
    nodePort: 30001   # Puerto asignado en el nodo, opcional
  selector:
    app: juan-condori-00-deployment  # Debe coincidir con las etiquetas del Deployment
EOF

# ✅ 4. Configmap
cat << 'EOF' > be/juan-condori-00-configmap.yml
# kubectl apply -f juan-condori-00-configmap.yml
# kubectl delete -f juan-condori-00-configmap.yml
apiVersion: v1
kind: ConfigMap
metadata:
  name: juan-condori-00-configmap
  namespace: juan-condori-00-namespace
data:
  MONGO_DATABASE: database_cloud
  MONGO_URI: mongodb+srv://juan:12345@cluster0.zdl9n.mongodb.net/?appName=Cluster0
  SERVER_PORT: "8081"
EOF


echo "Archivos creados exitosamente en la carpeta 'be/':"
ls -l be/


# ✅ Opción 1: Aplicar todos los manifiestos en Kubernetes por carpeta
echo "Ejecutando la carpeta 'be' en el clúster de Kubernetes..."
kubectl apply -f be/

# ✅ Opeción 2: Aplicar todos los manifiestos en Kubernetes archivo por archivo
kubectl apply -f juan-condori-00-namespace.yml
kubectl apply -f juan-condori-00-configmap.yml
kubectl apply -f juan-condori-00-secret.yml
kubectl apply -f juan-condori-00-service.yml
kubectl apply -f juan-condori-00-deployment.yml


