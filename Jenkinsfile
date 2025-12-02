pipeline {
    agent any

    tools {
        maven 'Maven3'     
        jdk 'Java21'        
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn -B test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo 'Build & Tests passed. Pipeline green.'
        }
        failure {
            echo 'Pipeline failed. Fix the issues and re-run.'
        }
    }
}
