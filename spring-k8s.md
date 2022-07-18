1. Start minikube with docker as a driver
```
minikube start --driver=docker
```

2. To verify if minikube is started successfully or not
```
minikube status
```

3. To verify that a single node cluster has been initiated
```
kubectl cluster-info
```

4. To see that single node residing inside k8s cluster
```
kubectl get nodes
```

5. To allow kubernetes to read my local docker repositories
```
minikube docker-env
```

6. To view the current local docker images
```
docker images
```

7. Move to the directory containing spring-boot application and build the docker image
```
docker build -t spring-boot-k8s:v0.0.1 .
```
```
docker images
```

8. We want to run the built image inside the k8s-pod, for that we need a deployment object (d.o. are k8s obj that are used for managing the pods). So crete a deployment object by running-
```
kubectl create deployment spring-boot-k8s-deploy --image spring-boot-k8s:v0.0.1 --port=8080
```
We're creating the D.O. that reads the docker image created previously by us and exposes port 8080


9. To verify the deployment
```
kubectl get deployments
```

10. To get description about the created deployment
```
kubectl describe deployment spring-boot-k8s-deploy
```

