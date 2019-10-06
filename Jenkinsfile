pipeline {
     agent any
     stages {
          stage("Checkout") {
               steps {
                    git url: 'https://github.com/gustavogmartinelli/contaCorrenteMs.git'
               }
          }
          stage ('Build') {
            steps {
                sh 'docker run --rm --name ContaCorrenteMS -v "$PWD":/usr/src/app -w /usr/src/app maven:3.6.2-jdk-8s mvn clean install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
     }
}