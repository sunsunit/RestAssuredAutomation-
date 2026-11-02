pipeline {
    agent any
 
    stages {
 
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Source code checkout completed'
            }
        }
 
        stage('Verify Tools') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }
 
        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
 
    post {
        always {
            junit(
                testResults: 'target/surefire-reports/*.xml',
                allowEmptyResults: true
            )
 
            archiveArtifacts(
                artifacts: 'target/surefire-reports/*,target/cucumber-report.html,logs/automation.log',
                allowEmptyArchive: true
            )
        }
 
        success {
            echo 'API Automation Execution Successful'
        }
 
        failure {
            echo 'API Automation Execution Failed'
        }
    }
}