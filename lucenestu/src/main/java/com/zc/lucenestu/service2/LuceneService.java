package com.zc.lucenestu.service2;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

import java.io.*;

/**
 * This class demonstrate the process of creating index with Lucene
 * for text files
 */
public class LuceneService {

    public static final String filePath = "D:\\DevelopmentTool\\IntelliJ IDEA 2017.2.6\\workspace\\FileLocation\\spbtworkspace\\lucenestu\\data2";
    public static final String filIndex = "D:\\DevelopmentTool\\IntelliJ IDEA 2017.2.6\\workspace\\FileLocation\\spbtworkspace\\lucenestu\\index2";

    public static void main(String[] args) throws Exception {
        batchWriteFile();
        luceneIndexGene();    //20000个文件生成索引，耗时：363330毫秒
    }

    public static void luceneIndexGene() throws Exception{
        //indexDir is the directory that hosts Lucene's index files
        File   indexDir = new File(filIndex);
        //dataDir is the directory that hosts the text files that to be indexed
        File   dataDir  = new File(filePath);
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

    /**
     * 向文件中写入内容
     * @param filepath 文件路径与名称
     * @param newstr  写入的内容
     * @return
     * @throws IOException
     */
    public static boolean writeFileContent(String filepath,String newstr) throws IOException {
        Boolean bool = false;
        String filein = newstr+"\r\n";//新写入的行，换行
        String temp  = "";

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos  = null;
        PrintWriter pw = null;
        try {
            File file = new File(filepath);//文件路径(包括文件名称)
            //将文件读入输入流
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();

            //文件原有内容
            for(int i=0;(temp =br.readLine())!=null;i++){
                buffer.append(temp);
                // 行与行之间的分隔符 相当于“\n”
                buffer = buffer.append(System.getProperty("line.separator"));
            }
            buffer.append(filein);

            fos = new FileOutputStream(file);
            pw = new PrintWriter(fos);
            pw.write(buffer.toString().toCharArray());
            pw.flush();
            bool = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            //不要忘记关闭
            if (pw != null) {
                pw.close();
            }
            if (fos != null) {
                fos.close();
            }
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
        return bool;
    }

    public static void batchWriteFile() throws IOException {
        File file;
        for (int i=0;i<4;i++){
            String fileName = i+".txt";
            String fileContent;
            if (i % 3 == 0) {
                fileContent = "清明好aaabbbccc";
            }else {
                fileContent = "重阳好aaadddeee";
            }
            file = new File(filePath, fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            writeFileContent(filePath + "\\" + fileName, fileContent);
        }
    }
}
