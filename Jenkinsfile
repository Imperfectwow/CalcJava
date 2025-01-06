pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64' // Update if using a different JDK path
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                checkout scm
            }
        }
        stage('Setup JDK') {
            steps {
                echo 'Setting up JDK 17...'
                sh 'java -version'
            }
        }
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                    echo 'Build artifacts have been archived.'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' // Collect test results
                }
            }
        }
        stage('Dependency Graph') {
            steps {
                echo 'Generating dependency graph...'
                sh 'mvn com.github.ferstl:depgraph-maven-plugin:4.0.1:graph -DgraphFormat=json'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/dependency-graph.json', fingerprint: true
                    echo 'Dependency graph has been archived.'
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed. Check the logs for more details.'
        }
    }
}
