pipeline {
    agent any

    environment {
        // Variables d'environnement
        DOCKER_IMAGE = "springboot-app"
        DOCKER_TAG = "latest"
        REGISTRY = "docker.io"  // Vous pouvez changer cela si vous utilisez un autre registre Docker
    }

    stages {
        stage('Checkout') {
            steps {
                // Vérifie le code à partir de votre dépôt Git
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    // Construction du projet avec Maven
                    sh './mvnw clean package -DskipTests' // Utilisez ./mvnw pour garantir que Maven Wrapper est utilisé
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Exécution des tests unitaires
                    sh './mvnw test'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Créer l'image Docker pour l'application Spring Boot
                    sh 'docker build -t $DOCKER_IMAGE:$DOCKER_TAG .'
                }
            }
        }

        stage('Push to Docker Registry') {
            when {
                branch 'main' // Vous pouvez changer la condition selon vos branches
            }
            steps {
                script {
                    // Connexion à Docker Hub et push de l'image
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                        sh "docker push $DOCKER_IMAGE:$DOCKER_TAG"
                    }
                }
            }
        }

        stage('Deploy to Docker') {
            steps {
                script {
                    // Déployer l'application Spring Boot dans un conteneur Docker
                    sh "docker run -d --name springboot-app -p 8080:8080 $DOCKER_IMAGE:$DOCKER_TAG"
                }
            }
        }

        stage('Clean Up') {
            steps {
                script {
                    // Nettoyer les anciennes images Docker pour libérer de l'espace
                    sh 'docker system prune -f'
                }
            }
        }
    }

    post {
        always {
            // Actions après chaque build, qu'il réussisse ou non
            cleanWs()  // Nettoyer l'espace de travail Jenkins
        }
        success {
            // Actions lorsque le pipeline réussit
            echo "Build et déploiement réussis!"
        }
        failure {
            // Actions lorsque le pipeline échoue
            echo "Le pipeline a échoué"
        }
    }
}
