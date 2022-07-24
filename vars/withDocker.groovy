import Docker

def call(Map config) {
  def docker = new Docker(this, config)
  docker.build()
  docker.login()
  docker.push(imageName)
}
