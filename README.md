# spring-cloud-app
This repository is intended to show/test the features available in Spring Cloud to create 
high scalable, available, distributed web applications.

In order to support at least three Eureka discovery services it is mandatory to run the EurekaDiscoveryServer 
application 3 times with different profiles: to do so we need to execute the following steps:
  
  1. Edit your computer's /etc/hosts file (c:\WINDOWS\system32\drivers\etc\hosts on Windows). 
     Add the following lines and save your work:
     
      127.0.0.1       eureka-primary
      127.0.0.1       eureka-secondary
      127.0.0.1       eureka-tertiary
      
  2. Run the application 3 times, using -Dspring.profiles.active=primary (and secondary, and tertiary) to activate the 
     relevant profile. The result should be 3 Eureka servers which communicate with each other.
     
     Gradle Commands: 
        SPRING_PROFILES_ACTIVE=primary gradle bootRun
        SPRING_PROFILES_ACTIVE=secondary gradle bootRun
        SPRING_PROFILES_ACTIVE=tertiary gradle bootRun
        
  3. Run a docker container with RabbitMQ so that the server config and the clients applications are able to upgrade the beans when            updating properties. To do so, execute the next command:
        
        docker run -d --hostname rabbitmq --name rabbitmq -p 15672:15672 -p 5672:5672 -v /home/docker/volumes/rabbitmq:/var/lib/rabbitmq 
        -e RABBITMQ_DEFAULT_USER=rabbit -e RABBITMQ_DEFAULT_PASS=rabbit rabbitmq:3-management
        
     IMPORTANT: Take into account thar you probably need to change the ip address of your Virtual Machine
                where your docker container is running in every AmqpConfig.java files.
     
