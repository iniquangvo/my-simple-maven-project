def build() {
    wsdir = pwd()
    stage('Preparation') {
        sh "echo ${wsdir}"
        checkout([$class: 'GitSCM',
            branches: [[name: '*/main']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [],
            submoduleCfg: [],
            userRemoteConfigs: [[url: 'https://github.com/iniquangvo/my-simple-maven-project.git']]
        ])
    }
    stage('Build') {
        withMaven(maven: 'Maven 3.9.0') {
            sh 'mvn clean verify'
        }
    }
    stage('Test') {
        withMaven(maven: 'Maven 3.9.0') {
            sh "mvn clean package"
        }
    }
}

timeout(time: 12, unit: 'HOURS') {
    timestamps() {
        node('linux') {
            build()
        }
    }
}