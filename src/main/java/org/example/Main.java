package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //1 strategia, 2 parametr ,3 nazwa pliku z ktorego ma wczytac, 4 nazwa pliku z rozwiazaniem
        //5 nazwa pliku z dodatkowymi informacjami
        if(args.length != 5) throw new RuntimeException("Niepoprawna liczba argumentów");
        for (int i = 2; i< 5; i++) {
            if(!args[i].endsWith(".txt")) {
                throw new RuntimeException("Niepoprawny format plików");
            }
        }
            FileManagement fileManagement = new FileManagement();
            Stopwatch stopwatch = new Stopwatch();
            double timeElapsed;
        try {
            FifteenPuzzle fifteenPuzzle = new FifteenPuzzle(args[2]);
            switch(args[0]) {
                case "bfs":
                    stopwatch.start();
                    BFS bfs = new BFS(20,fifteenPuzzle,args[1]);
                    timeElapsed = stopwatch.stop();
                    fileManagement.saveToFile(args[3],fileManagement.solutionFileContent(bfs.getSolutionLength(), bfs.getSolution()));
                    fileManagement.saveToFile(args[4],fileManagement.extraInfoFile(bfs.getSolutionLength(), bfs.getBfsVisited(), bfs.getBfsProcessed(), bfs.getBfsMaxDepth(), timeElapsed));
                    break;
                case "dfs":
                    stopwatch.start();
                    DFS dfs = new DFS(20,fifteenPuzzle,args[1]);
                    timeElapsed = stopwatch.stop();
                    fileManagement.saveToFile(args[3],fileManagement.solutionFileContent(dfs.getSolutionLength(), dfs.getSolution()));
                    fileManagement.saveToFile(args[4],fileManagement.extraInfoFile(dfs.getSolutionLength(), dfs.getDfsVisited(), dfs.getDfsProcessed(), dfs.getDfsMaxDepth(), timeElapsed));
                    break;
                case "astr":
                    AStar aStar = new AStar(fifteenPuzzle);
                    System.out.println("gitara");
                    switch (args[1]){
                        case "hamm":
                            stopwatch.start();
                            aStar.findSolution(true);
                            timeElapsed = stopwatch.stop();
                            fileManagement.saveToFile(args[3],fileManagement.solutionFileContent(aStar.getSolutionLength(), aStar.getSolution()));
                            fileManagement.saveToFile(args[4],fileManagement.extraInfoFile(aStar.getSolutionLength(), aStar.getAStarVisited(), aStar.getAStarProcessed(), aStar.getAStarMaxDepth(), timeElapsed));
                            break;
                        case "manh":
                            stopwatch.start();
                            aStar.findSolution(false);
                            timeElapsed = stopwatch.stop();
                            fileManagement.saveToFile(args[3],fileManagement.solutionFileContent(aStar.getSolutionLength(), aStar.getSolution()));
                            fileManagement.saveToFile(args[4],fileManagement.extraInfoFile(aStar.getSolutionLength(), aStar.getAStarVisited(), aStar.getAStarProcessed(), aStar.getAStarMaxDepth(), timeElapsed));
                            break;
                        default:
                            throw new RuntimeException("Niepoprawne argumenty1");
                    }
                    break;
                default:
                    throw new RuntimeException("Niepoprawne argumenty");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}