## Docker

#### Running the application manually via docker container

* 	[anantha/spring-boot-minimal-web-app](https://hub.docker.com/r/anantha/spring-boot-minimal-web-app) - DockerHub Image

DockerHub Pull Command if you want to directly pull the docker image of the application from Docker Hub.

```shell
docker pull anantha/spring-boot-minimal-web-app:latest
```

**NOTE:** If you want to build a docker image from the source code, ensure you build a jar of the application before building a docker image.  

```shell
$ mvn package -Dmaven.test.skip=true     //skip all tests and build. The build once completed is available in **target** folder
```

```shell
$ mvn clean package                      //run all tests and build
```

A runnable jar file gets built and is available in the **target** folder

On Windows machine use **Docker Quickstart Terminal** or, use **Windows Powershell** and navigate to the project folder where Dockerfile is present.

#### Docker Commands

##### Build Docker Image from Dockerfile

`docker images`  
`docker build -t spring-boot-minimal-web-app .`  
`docker images`  

##### Run & Stop the Docker Image built from previous step

`docker run -p 8080:8080 --name spring-boot-minimal-web-app spring-boot-minimal-web-app`  
`docker ps`  
`docker stop spring-boot-minimal-web-app`
`docker ps -a`  

##### Docker Tag image with dockerhub username and push it to dockerhub

`docker tag spring-boot-minimal-web-app anantha/spring-boot-minimal-web-app:latest`  
`docker images`  
`docker push anantha/spring-boot-minimal-web-app:latest`  

##### Remove Docker Image

`docker images`  
`docker image rm spring-boot-minimal-web-app`  
`docker image rm -f spring-boot-minimal-web-app`  

#### Basic Docker commands for reference

Checkout additional Docker and DockerHub commands here, [https://github.com/AnanthaRajuC/Hacks-and-Code-Snippets/blob/master/Docker.md](https://github.com/AnanthaRajuC/Hacks-and-Code-Snippets/blob/master/Docker.md) 

|                           Command                                  |                                     Description                               |
|--------------------------------------------------------------------|-------------------------------------------------------------------------------| 
|`docker-machine ip default`							             | check your docker IP default, usually it is **192.168.99.102**			     |
|`docker images`                                                     | take a look at the container images.                                          |
|`docker ps`                                                         | list all the running containers.                                              |
|`docker ps -a`                                                      | list all the containers, including the ones that have finished executing.     |
|`docker restart [container_name]`							         | restart the docker image			                             		         |
|`docker stats`							                             | Show CPU and memory usage of all running containers                 	         |
|`docker stats [container_name]`						             | Show CPU and memory usage of a particular running container                   |
|`docker stats [container1_name] [container2_name]`			         | Show CPU and memory usage of container1, container2                           |
|`docker top [container_name]`			                             | Show running processes in a container                                         |
|`docker system df`			                                         | Show storage usage                                                            |
|`docker logs [container_id]`			                             | list container logs                                                           |
|`docker logs [container_id] --tail N`                               | list container logs, **`--tail`** flag will show the last **N** lines of logs |   
|`docker logs [container_id] --since YYYY-MM-DD`                     | list container logs since a particular date                                   |
|`docker logs [container_id] --since YYYY-MM-DDTHH:MM:SS.000000000Z` | list container logs since a particular timestamp                              |

##### Docker Hub Commands for Reference     

|                               Command                              |                         Description                               |
|--------------------------------------------------------------------|-------------------------------------------------------------------| 
|`docker logout`							                         | logout of Docker Hub from the local machine.                      |
|`docker login --username=YOUR_DOCKERHUB_USERNAME`	                 | login to Docker Hub from your machine.                            |
|`docker tag <existing-image> <hub-user>/<repo-name>[:<tag>]`        | re-tagging an existing local image					             |
|`docker commit <existing-container> <hub-user>/<repo-name>[:<tag>]` | commit changes					                                 |
|`docker push <hub-user>/<repo-name>:<tag>`                          | push this repository to the registry designated by its name or tag|

**Examples:**

*	re-tagging an existing local image : `docker tag spring-boot-minimal-web-app anantha/spring-boot-minimal-web-app:h2db-profile`
*	commit changes                     : `docker commit pedantic_turing anantha/spring-boot-minimal-web-app:h2db-profile`
*	docker push                        : `docker push anantha/spring-boot-minimal-web-app:h2db-profile`
