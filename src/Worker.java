public class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;
    private int error = -1;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback, int error) {
        this.callback = callback;
        this.errorCallback = errorCallback;
        this.error = error;
    }

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != error) {
                callback.onDone("Task " + i + " is done");
            } else {
                errorCallback.onError("Task " + i + " is error");
            }
        }
    }
}