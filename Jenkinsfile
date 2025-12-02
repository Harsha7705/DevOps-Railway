pipeline {
    agent any

    tools {
        maven 'Maven3'      
        jdk 'Java21'       
    }

    environment {
        TOMCAT_HOME = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out source code..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building the project..."
                bat 'mvn -B clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running unit tests..."
                bat 'mvn -B test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo "Packaging WAR..."
                bat 'mvn -B package'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                echo "Deploying WAR to Tomcat..."
        
                bat "\"%TOMCAT_HOME%\\bin\\shutdown.bat\""
            
                bat "copy /Y target\\*.war \"%TOMCAT_HOME%\\webapps\\\""
          
                bat "\"%TOMCAT_HOME%\\bin\\startup.bat\""
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully! CI + CD done.'
        }
        failure {
            echo 'Pipeline failed. Check logs and fix issues.'
        }
    }
}
