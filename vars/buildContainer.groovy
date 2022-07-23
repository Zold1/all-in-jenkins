import Docker 

def call(String imageName) {
    def docker = new Docker(this)
    docker.build(imageName).login().push(imageName)
}