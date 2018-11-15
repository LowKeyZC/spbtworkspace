package com.zc.lucenestu.service2;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.*;

/**
 * This class is used to demonstrate the
 * process of searching on an existing
 * Lucene index
 *
 */
public class TxtFileSearcher {
    public static void main(String[] args) throws Exception{
        searchOneByOne();  //20000个文件 包含清明字符串的文件数量：6667,查询总耗时：31535
        searchByLucene();   //20000个文件 包含清明字符串的文件数量：

    }

    public static void searchByLucene() throws IOException {
        Long startTM = System.currentTimeMillis();
        String queryStr = "清明好aaabbbccc";
        //This is the directory that hosts the Lucene index
        File indexDir = new File(LuceneService.filIndex);
        FSDirectory directory = FSDirectory.getDirectory(indexDir,false);
        IndexSearcher searcher = new IndexSearcher(directory);
        if(!indexDir.exists()){
            System.out.println("The Lucene index is not exist");
            return;
        }
        Term term = new Term("contents",queryStr.toLowerCase());
        TermQuery luceneQuery = new TermQuery(term);
        Hits hits = searcher.search(luceneQuery);
        for(int i = 0; i < hits.length(); i++){
            Document document = hits.doc(i);
            System.out.println("File: " + document.get("path"));
        }
        Long endTM = System.currentTimeMillis();
        System.out.println("包含清明字符串的文件数量：" + hits.length() + "耗时：" + (endTM - startTM));
    }

    public static void searchOneByOne() throws IOException {
        Long startTM = System.currentTimeMillis();
        String path= LuceneService.filePath;
        int num = 0;
        File file = new File(path);
        File[] tempList = file.listFiles();
        for (File file1 : tempList) {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file1));
            BufferedReader br = new BufferedReader(reader);
            String line;
            line = br.readLine();
            if (line.contains("清明")) {
                num++;
                System.out.println("文件包含清明:"+file1.getName());
            }
            br.close();
        }
        Long endTM = System.currentTimeMillis();
        System.out.println("包含清明字符串的文件数量：" + num + ",查询总耗时：" + (endTM - startTM));
    }

    public void testMatchAllDocsQuery() throws Exception {

    }
}