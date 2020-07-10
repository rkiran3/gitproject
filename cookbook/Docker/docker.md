# DevOps 

DevOps = Dev and Ops

Dev = Development of software
Ops = Operation


Dev Team: Plans, Creates, Verify and Package sofware
Operations Team handles: Release, Configure and Monitoring of software

# Docker
Combines application and dependencies into image that can be run on any machine.

## Docker Image
Image is a file also called Docker File, this image never changes.

# Hello World

        docker run hello-world  

        ~$ sudo docker run hello-world
        [sudo] password for user: 
        
        Hello from Docker!
        
# List images downloaded

This command lists all the Docker images that have been downloaded so far, as we pull more images - expect those to show up in the list.

        $ sudo docker images
        [sudo] password for user: 
        REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
        hello-world         latest              bf756fb1ae65        6 months ago        13.3kB

# Pull images without running

We can get the images to our environment without running them, the command is  

        $ sudo docker pull python

# Delete Docker Image

        $ sudo docker rmi hello-world
        Will show error since container is still active, 

        $ sudo docker container ls -a
        CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS                   PORTS               NAMES
        b42337828f76        hello-world         "/hello"            4 hours ago         Exited (0) 4 hours ago                       serene_nash

        $ sudo docker container ls # or ls -a to list all 
        
        $ sudo docker rm b4

##  To remove all the images

        $ sudo docker system prune