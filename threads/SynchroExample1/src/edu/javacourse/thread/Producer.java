package edu.javacourse.thread;

public class Producer extends Thread
{
    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }
    
    public void run() {
        for(int i=0; i<Resource.COUNT; i++) {
            resource.put(i);
        }
    }
}
