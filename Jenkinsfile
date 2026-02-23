pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling...'
                git branch: 'master',
                    url: 'https://github.com/nihed-eng/devops.git'
            }
        }

        stage('Testing maven') {
            steps {
                sh 'mvn -version'
            }
        }
    }
}
