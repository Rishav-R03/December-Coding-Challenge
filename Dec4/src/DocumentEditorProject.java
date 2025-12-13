import java.time.LocalDateTime;

/**
 * Document class having access based on three roles
 * 1. Viewer
 * 2. Editor
 * 3. Admin

 * Development includes two interfaces
 * 1. DocumentReader
 * 2. DocumentEditor
 */
class Document{
    private String content;
    private final String owner;
    private String lastModified;

    public Document(String content,String owner,String lastModified){
        this.content = content;
        this.owner = owner;
        this.lastModified = lastModified;
    }

    //1. Feature 1: Delegated Content Reading
    public String getContent(DocumentReader documentReader){
        return documentReader.readContent(this.content);
    }
    //2. Feature 2: Delegated Content Editing
    public void edit(DocumentEditor documentEditor,String newContent){
        this.content = documentEditor.editContent(this.content,newContent);
        LocalDateTime localDateTime = LocalDateTime.now();
        this.lastModified = localDateTime.toString();
    }
    //3. Feature 3: Metadata access (Must be handled in the main role access)
    public String getLastModified(){
        return lastModified;
    }
    public String getOwner(){
        return owner;
    }
}
class DocUserView implements DocumentReader{
    @Override
    public String readContent(String fullContent){
        return "**** Masked Content***";
    }
}
class EditorView implements DocumentReader{
    @Override
    public String readContent(String fullContent){
        return fullContent;
    }
}class DocAdminView implements DocumentReader{
    private static final int MAX_CONTENT_LENGTH = 50;
    @Override
    public String readContent(String fullContent){
       if(fullContent.length() <= MAX_CONTENT_LENGTH){
           return fullContent;
       }
       return fullContent.substring(0,MAX_CONTENT_LENGTH) + "...[MASKED]";
    }
}
// Feature 1: Role-Based Content Access
interface DocumentReader{
    String readContent(String fullContent);
}

// Feature 2: Role-Based Editing
interface DocumentEditor {
    String editContent(String currentContent,String newContent);
}

class DocUserEdit implements DocumentEditor {
    @Override
    public String editContent(String curr, String newContent) {
        System.out.println("Edit denied. Only the admin and the editor are allowed to edit.");
        return curr;
    }
}

class DocEditor implements DocumentEditor{
    @Override
    public String editContent(String curr, String newContent){
        return newContent;
    }
}
class AdminDocEditor implements DocumentEditor{
    @Override
    public String editContent(String curr, String newContent){
        return curr = newContent;
    }
}

public class DocumentEditorProject {
    static void main(String [] args){
        Document document1 = new Document("This is new content, which is longer than 50 character because of this much content.","Rishav","22:45:22");
        DocumentEditor userEditor1 = new DocUserEdit();
        DocumentEditor editor1 = new DocEditor();
        DocumentEditor admin1 = new AdminDocEditor();
        DocumentReader userReader1 = new DocUserView();
        DocumentReader editorReader1 = new EditorView();
        DocumentReader adminReader1 = new DocAdminView();
        String before = document1.getContent(userReader1);
        document1.edit(userEditor1,"This is the new content");
        String after = document1.getContent(userReader1);
        System.out.println(before);
        System.out.println(after);
    }
}
