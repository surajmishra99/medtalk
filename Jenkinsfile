pipeline {
    agent any
        tools{
            maven 'maven_3.8.6'
        }
    stages {
        stage('Checkout from github'){
            steps{
                 checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/surajmishra99/medtalk.git']]])
            }
        }
        stage('Build stage') {
            steps {
                script{
                    sh 'mvn clean install'
                }
            }
        }
    }
}