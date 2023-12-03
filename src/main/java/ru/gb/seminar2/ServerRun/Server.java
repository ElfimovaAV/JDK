package ru.gb.seminar2.ServerRun;

public class Server implements ServerListener{
    boolean isServerWorking;
    private Listener listener;

    public Server(Listener listener) {
        this.listener = listener;
        this.isServerWorking = false;
    }

    public void start() {
        if (!isServerWorking) {
            isServerWorking = true;
            listener.messageRes("Статус сервера: " + isServerWorking);
        } else {
            listener.messageRes("Сервер запущен");
        }

    }

    public void stop() {
        if (isServerWorking) {
            isServerWorking = false;
            listener.messageRes("Статус сервера: " + isServerWorking);
        } else {
            listener.messageRes("Сервер не запущен");
        }

    }


    @Override
    public void serverListener(boolean status) {

        if (status){
            stop();
        } else {
            start();
        }

    }
}
