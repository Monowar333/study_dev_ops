#!/usr/bin/env groovy
pipeline {
 agent any
 stages {
	stage('Build') {
	    steps {
	   	    echo 'Build and Test'
	   	    sh 'chmod +x ./gradlew'
	   	    sh './gradlew clean test'
	    }
	 }
 }

 post {
    always {
        sh 'chmod +x ./gradlew'
        sh './gradlew clean'
    }
    }
 }