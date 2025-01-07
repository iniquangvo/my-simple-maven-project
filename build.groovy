def build() {
    wsdir = pwd()
    stage('Preparation') {
        sh "echo ${wsdir}"
    }
    stage('Build') {
        sh "mvn clean verify"
    }
    stage('Test') {
        sh "mvn clean package"
    }
}

timeout(time: 12, unit: 'HOURS') {
    timestamps() {
        node('linux') { //'ub-build-itest') {
            build()
        }
    }
}