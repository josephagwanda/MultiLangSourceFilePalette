package org.netbeans.modules.multilangsourcefilepalette.python.Comments.InlineComment;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.modules.multilangsourcefilepalette.PaletteUtilities;
import org.openide.text.ActiveEditorDrop;

public class InlineComment implements ActiveEditorDrop {

    private String comment = "";

    public InlineComment() {
    }

    private String createBody() {
        comment = getComment();
        String Comment = "# " + comment;
        return Comment;
    }

    @Override
    public boolean handleTransfer(JTextComponent targetComponent) {

        CommentCustomizer c = new CommentCustomizer(this, targetComponent);
        boolean accept = c.showDialog();
        if (accept) {
            String body = createBody();
            try {
                PaletteUtilities.insert(body, targetComponent);
            } catch (BadLocationException ble) {
                accept = false;
            }
        }

        return accept;

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
