pipeline {
    agent { label 'slave' }



    stages {
        stage('Checkout') {
            steps {
                // Get the latest code from the SCM
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                // Compile the project using Maven
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                // Run unit tests using Maven
                sh 'mvn test'
            }
            post {
                always {
                    // Archive the test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // Publish HTML reports (if any)
                    publishHTML(target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/surefire-reports',
                        reportFiles: 'index.html',
                        reportName: 'JUnit Report'
                    ])
                }
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
        always {
            // Clean up the workspace to free space after the build is done
            cleanWs()
        }
    }
}
