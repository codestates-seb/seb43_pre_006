import React, { useEffect, useState } from "react";
import { Editor } from "react-draft-wysiwyg";
import "react-draft-wysiwyg/dist/react-draft-wysiwyg.css";
import styled from "styled-components";
import { EditorState, convertToRaw } from "draft-js";
import draftToHtml from "draftjs-to-html";

const MyBlock = styled.div`
  .wrapper-class {
    width: 100%;
    max-width: 851px;
    margin-bottom: 1rem;
    margin-top: 30px;
  }
  .editor {
    height: 300px !important;
    border: 1px solid #e4e6e8 !important;
    padding: 5px !important;
    border-radius: 2px !important;
  }
`;

const ContainerBtn = styled.div`
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

const QuestionPageEditor = () => {
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
        <div className="postBtn">Post Your Answer</div>
      </ContainerBtn>
    </>
  );
};

export default QuestionPageEditor;
