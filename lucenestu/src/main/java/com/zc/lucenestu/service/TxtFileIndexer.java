package com.zc.lucenestu.service;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Date;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
/**
 * This class demonstrate the process of creating index with Lucene
 * for text files
 */
public class TxtFileIndexer {
    public static void main(String[] args) throws Exception{
        //indexDir is the directory that hosts Lucene's index files
        File   indexDir = new File("D:\\DevelopmentTool\\IntelliJ IDEA 2017.2.6\\workspace\\FileLocation\\spbtworkspace\\lucenestu\\index");
        //dataDir is the directory that hosts the text files that to be indexed
        File   dataDir  = new File("D:\\DevelopmentTool\\IntelliJ IDEA 2017.2.6\\workspace\\FileLocation\\spbtworkspace\\lucenestu\\data");
        Analyzer luceneAnalyzer = new StandardAnalyzer();
        File[] dataFiles  = dataDir.listFiles();
        IndexWriter indexWriter = new IndexWriter(indexDir,luceneAnalyzer,true);
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < dataFiles.length; i++){
            if(dataFiles[i].isFile() && dataFiles[i].getName().endsWith(".txt")){
                System.out.println("Indexing file " + dataFiles[i].getCanonicalPath());
                Document document = new Document();
                Reader txtReader = new FileReader(dataFiles[i]);
                document.add(Field.Text("path",dataFiles[i].getCanonicalPath()));
                document.add(Field.Text("contents",txtReader));
                indexWriter.addDocument(document);
            }
        }
        indexWriter.optimize();
        indexWriter.close();
        long endTime = System.currentTimeMillis();

        System.out.println("It takes " + (endTime - startTime)
                + " milliseconds to create index for the files in directory "
                + dataDir.getPath());
    }
}