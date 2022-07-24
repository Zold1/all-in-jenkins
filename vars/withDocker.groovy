import Docker

def call(Map config) {
  def docker = new Docker(this, Map config)
  docker.build()
  docker.login()
  docker.push(imageName)
}
