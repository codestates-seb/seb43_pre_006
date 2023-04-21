import React, { useEffect, useState } from "react";
import { Editor } from "react-draft-wysiwyg";
import "react-draft-wysiwyg/dist/react-draft-wysiwyg.css";
import styled from "styled-components";
import { EditorState, convertToRaw } from "draft-js";
import draftToHtml from "draftjs-to-html";

const MyBlock = styled.div`
  opacity: 0.3;
  cursor: not-allowed;

  .wrapper-class {
    width: 70%;
    margin-bottom: 1rem;
    margin-top: 30px;
  }

  .editor {
    background-color: white;
    border: solid 1px ${({ theme }) => theme.black200};
    height: 300px !important;
    padding: 5px !important;
    border-radius: 2px !important;
  }
`;

const ContainerBtn = styled.div`
  opacity: 0.3;
  cursor: not-allowed;
  > .postBtn {
    padding: 10px;
    background-color: ${({ theme }) => theme.blue500};
    color: white;
    border-radius: 0.2rem;
    display: inline-block;
    font-size: 13px;
    box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
    font-weight: 400;
    border: solid 1px transparent;
    cursor: pointer;
    margin-bottom: 12px;
    &:hover {
      background-color: ${({ theme }) => theme.blue600};
    }
  }
`;

const AskPageBottomArticle3 = () => {
  const [editorState, setEditorState] = useState(EditorState.createEmpty());

  const onEditorStateChange = (editorState) => {
    setEditorState(editorState);
  };

  const editorToHtml = draftToHtml(
    convertToRaw(editorState.getCurrentContent())
  );
  return (
    <>
      <MyBlock>
        <Editor
          wrapperClassName="wrapper-class"
          editorClassName="editor"
          toolbarClassName="toolbar-class"
          toolbar={{
            list: { inDropdown: true },
            textAlign: { inDropdown: true },
            link: { inDropdown: true },
            history: { inDropdown: false },
          }}
          placeholder=""
          localization={{
            locale: "ko",
          }}
          editorState={editorState}
          onEditorStateChange={onEditorStateChange}
        />
      </MyBlock>
      <ContainerBtn>
        <div className="postBtn">Post Your Ask</div>
      </ContainerBtn>
    </>
  );
};

export default AskPageBottomArticle3;
