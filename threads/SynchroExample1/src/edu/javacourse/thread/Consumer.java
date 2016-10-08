package edu.javacourse.thread;

public class Consumer extends Thread
{
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }
    
    public void run() {
        for(int i=0; i<Resource.COUNT; i++) {
            resource.get();
        }
    }
}
