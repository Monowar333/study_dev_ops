#!/usr/bin/env groovy
pipeline {
 agent any
 stages {
	stage('Build') {
	    steps {
	   	    echo 'Build'
	   	    sh './gradlew clean test'
	    }
	 }
 }

 post {
    always {
        sh './gradlew clean'
    }
    }
 }