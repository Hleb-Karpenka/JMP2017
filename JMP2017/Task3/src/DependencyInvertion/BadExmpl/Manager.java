package DependencyInvertion.BadExmpl;

// Dependency Inversion Principle - Bad example


public class Manager {

    Worker worker;

    public void setWorker(Worker w) {
        worker = w;
    }

    public void manage() {
        worker.work();
    }
}

class Worker {

    public void work() {
        // ....working
    }

}

class SuperWorker {
    public void work() {
        //.... working much more
    }
}