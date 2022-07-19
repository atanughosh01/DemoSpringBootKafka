1. Start minikube with docker as a driver
```
minikube start --driver=docker
```
<br>

2. To verify if minikube is started successfully or not
```
minikube status
```
<br>

3. To verify that a single node cluster has been initiated
```
kubectl cluster-info
```
<br>

4. To see that single node residing inside k8s cluster
```
kubectl get nodes
```
<br>

5. To allow kubernetes to read my local docker repositories
```
minikube docker-env
```
<br>

6. To view the current local docker images
```
docker images
```
<br>

7. Move to the directory containing spring-boot application and build the docker image
```
docker build -t spring-boot-k8s:v0.0.1 .
```
```
docker images
```
<br>

8. We want to run the built image inside the k8s-pod, for that we need a `dployment` object (dployment objects are k8s objects, which are used for managing the pods). So create a deployment object by running-
```
kubectl create deployment spring-boot-k8s-deploy --image spring-boot-k8s:v0.0.1 --port=8080
```
We're creating the D.O. that reads the docker image created previously by us and exposes port 8080

<br>

9. To verify the deployment
```
kubectl get deployments
```
<br>

10. To get description about the created deployment
```
kubectl describe deployment spring-boot-k8s-deploy
```
<br>

11. To ensure that kubernetes successfully pulled the docker images and is able to run inside pods
```
kubectl get pods
```
<br>

12. To verify that kubernetes is able to run a conatiner inside the above pod, we'll check the `logs` of the pod-
```
kubectl logs spring-boot-k8s-deploy-66d8b9d9fc-g8t2w
```
If the spring-boot application runs that means it is running inside the container residing in the pod.

<br>

13. Now we need to create a `service` object and then we need to expose the current `deployment` with correct `service` tag, so that the application can be accessed from outside of this k8s-cluster (basically we need to expose our deployment to create a service object). Significance: All the traffics will come to the `service` first, then `service` will redirect it to the corresponding pods based on availability.
```
kubectl expose deployment spring-boot-k8s-deploy --type=NodePort
```
<br>

14. Type the following to verify that the `service` object is successfully created-
```
kubectl get services
```
<br>

15. Since we have one pod, we can directly get that service URL to point to that particular endpoint-
```
minikube service spring-boot-k8s-deploy --url
```
  By doing this we will directly get the service url/proxy url to access our endpoint.
 
<br>

16. We can also check health/status of each components (nodes, pods, deployments, proxy etc) of our k8s-cluster.
```
minikube dashboard
```
<br>

17. After ending the above session, clean-up all the configs and components which we created (not mandatory but it's good to do the clean-up).
```
kubectl delete service spring-boot-k8s-deploy
```
```
kubectl delete deployment spring-boot-k8s-deploy
```
<br>

18. Stop the `minikube` instance and then delete the `minikube` object
```
minikube stop
```
<br>

19. Verify if it is stopped or not-
```
kubectl get nodes
```
<br>

20. Delete the local kubernetes cluster.
```
minikube delete
```
