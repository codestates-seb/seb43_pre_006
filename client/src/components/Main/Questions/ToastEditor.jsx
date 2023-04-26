import { useRef } from "react";

// Toast 에디터
import { Editor } from "@toast-ui/react-editor";
import "@toast-ui/editor/dist/toastui-editor.css";
import styled from "styled-components";
import axios from "axios";
import { useRecoilState, useRecoilValue } from "recoil";
import { textEditorState, titleText } from "../../store/atom";

export default function ToastEditor() {
  const [title, setTitle] = useRecoilState(titleText);
  const [allowEditor, setAllowEditor] = useRecoilState(textEditorState);
  console.log(allowEditor);
  // Editor DOM 선택용
  const editorRef = useRef();

  // 등록 버튼 핸들러
  const handleRegisterButton = () => {
    const cookie = document.cookie
      .split("; ")
      .find((row) => row.startsWith("user="));
    if (cookie) {
      const userId = cookie.split("=")[1];
      axios
        .post(`https://2c02-124-111-225-247.ngrok-free.app/questions/`, {
          title: title,
          content: editorRef.current?.getInstance().getMarkdown(),
        })
        .then((response) => {
          console.log("Score updated successfully");
        })
        .catch((error) => {
          console.error(error);
        });
      setAllowEditor(!allowEditor);
      setTitle("");
    } else {
      console.log("User is not logged in");
      window.location.href = "http://localhost:3000/login";
    }
  };

  return (
    <Container cursorAllow={allowEditor}>
      <Editor
        ref={editorRef} // DOM 선택용 useRef
        placeholder="내용을 입력해주세요."
        previewStyle="vertical" // 미리보기 스타일 지정
        height="300px" // 에디터 창 높이
        initialEditType="wysiwyg" //
        toolbarItems={[
          // 툴바 옵션 설정
          ["heading", "bold", "italic", "strike"],
          ["hr", "quote"],
          ["ul", "ol", "task", "indent", "outdent"],
          ["table", "image", "link"],
          ["code", "codeblock"],
        ]}
        useCommandShortcut={false}
        style={{
          // Editor 컴포넌트에 style 속성 추가
          cursor: allowEditor ? "auto" : "not-allowed", // allowEditor 값에 따라 cursor 값 설정
          opacity: allowEditor ? 1 : 0.3, // allowEditor 값에 따라 opacity 값 설정
        }}
        disabled={!allowEditor} // 키보드 입력 컨트롤 방지
      ></Editor>

      <BtnStyle onClick={handleRegisterButton} cursorAllow={allowEditor}>
        Post Your Answer
      </BtnStyle>
    </Container>
  );
}

const Container = styled.div`
  margin-top: 16px;
  cursor: ${({ cursorAllow }) => !cursorAllow && "not-allowed"} !important;
  opacity: ${({ cursorAllow }) => !cursorAllow && 0.5} !important;
`;

const BtnStyle = styled.button`
  margin-top: 16px;
  padding: 10px;
  background-color: ${({ theme }) => theme.blue500};
  color: white;
  border-radius: 0.2rem;
  display: block;
  font-size: 13px;
  box-shadow: inset 0 1px 0 0 hsla(0, 0%, 100%, 0.4);
  font-weight: 400;
  border: solid 1px transparent;
  cursor: ${({ cursorAllow }) => (!cursorAllow ? "not-allowed" : "pointer")};

  margin-bottom: 12px;
  &:hover {
    background-color: ${({ theme }) => theme.blue600};
  }
`;
