pipeline {
     agent any
     tools {
    }
     stages {
          stage("Checkout") {
               steps {
                    git url: 'https://github.com/gustavogmartinelli/contaCorrenteMs.git'
               }
          }
          stage ('Build') {
            steps {
                sh 'docker run -it --rm --name ContaCorrenteMS -v "$PWD":/usr/src/app -w /usr/src/app maven:3.2-jdk-7 mvn clean install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
     }
}