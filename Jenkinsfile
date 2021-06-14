pipeline {
    agent any
    triggers {
        pollSCM  '* * * * *'
    }
    stages {
        stage('compile stage') {
            steps {
                withMaven(maven : 'apache-maven-3.6.1'){
                bat 'mvn clean compile'
                }
            }
        }
        stage('Test stage') {
            steps {
              withMaven(maven : 'apache-maven-3.6.1'){
              bat 'mvn test'

              }
              post {
                  always {
                       junit 'target/surefire-reports/*.xml'
                        }
               }
            }

        }
        stage('Install Stage') {
            steps {
                 withMaven(maven : 'apache-maven-3.6.1'){
                 bat 'mvn install'
                 }
            }
        }
    }
}