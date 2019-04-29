//package utilities;
//
//public class Main {
//    public static void main(String[] args) {
//
//        String contentMeta = TransformationUtil.getXml("/home/lquran/Desktop/Litratum/okokok/web/test/0198742916688653.xml","/home/lquran/Desktop/Litratum/okokok/web/test/par.xsl");
//
//        String [] lines = contentMeta.split(System.lineSeparator());
//        String doi = lines[1].trim();
//        String subject = lines[2].trim();
//        String title = lines[3].trim();
//        String author = lines[4].trim();
//
//        ContentMeta contentMeta1 = new ContentMeta(doi,subject,title,author);
//        DAO contentDAO = new ContentMetaDAO();
//
//        contentDAO.insert(contentMeta1);
//
//
//    }
//}
