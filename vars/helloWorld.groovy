def call(body) {
    def config = [
            foo:  "bar",
            bar: "foo"
    ]

    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node() {
        try {
            stage("First step") {
                echo "Value for foo is ${config.foo}"
            }

            stage("Second step") {
                echo "Value for bar is ${config.bar}"
            }

        } catch (error) {
            error "Something is wrong ${error}"
        }

    }
}
