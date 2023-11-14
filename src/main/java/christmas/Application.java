package christmas;

import christmas.controller.PreviewController;

public class Application {
    public static void main(String[] args) {
        PreviewController previewController = PreviewController.create();
        previewController.run();
    }
}
