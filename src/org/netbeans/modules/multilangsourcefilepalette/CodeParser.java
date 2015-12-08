package org.netbeans.modules.multilangsourcefilepalette;

import java.util.ArrayList;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.openide.text.NbDocument;

public class CodeParser {

    private ArrayList<String> variableList;

    public CodeParser(JTextComponent target) {
        final StyledDocument doc = (StyledDocument) target.getDocument();
        variableList = new ArrayList<>();
        
    }

    private void parseCode(JTextComponent target, Document doc){
        
        
    }
    

}
