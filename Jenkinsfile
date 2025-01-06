pipeline {
    agent any
    tools {
        jdk 'JDK_21' 
        maven 'Maven' 
    }
    stages {
        stage('Set Up') {
            steps {
                echo "Setting up Java and Maven..."
                sh 'java -version' // Verify Java is correctly configured
                sh 'mvn -version'  // Verify Maven is correctly configured
            }
        }
        stage('Build') {
            steps {
                echo "Building the project..."
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo "Running tests..."
                sh 'mvn test'
            }
        }
        stage('Deploy to Tomcat') {
            steps {
                echo 'Deploying to Tomcat...'
                deploy adapters: [tomcat9(credentialsId: 'tomcat-credentials', 
                                          path: '',
                                          url: 'http://localhost:8070/manager/text')],
                       contextPath: 'calc-app',
                       war: '**/target/*.war'
            }
        } 
    }
}