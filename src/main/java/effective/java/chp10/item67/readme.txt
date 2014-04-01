Item 67: Avoid excessive synchronization

To avoid liveness and safety failures, never cede control to the client within a synchronized method or block.

Don't
    - Inside a synchronized region, do not invoke a method that is designed to be overridden, or one provided by a client
        in the form of a function object, i.e. such methods are alien - depending on what an alien method does, calling it from a
        synchronized region can cause exceptions, deadlocks, or data corruption.