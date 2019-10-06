pipeline {
     agent any
     tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
     stages {
          stage("Checkout") {
               steps {
                    git url: 'https://github.com/gustavogmartinelli/contaCorrenteMs.git'
               }
          }
          stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
     }
}