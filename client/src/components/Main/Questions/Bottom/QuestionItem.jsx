import React, { useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import styled from "styled-components";
import AddAsk from "./../Top/AddAsk";
import SideBar from "./../../SideBar/SideBar";
import ItemContent from "./Content/ItemContent";
import ItemTop from "./Content/ItemTop";
import ItemLeft from "./Content/ItemLeft";
import axios from "axios";
import ToastEditor from "../ToastEditor";

export default function QuestionItem({ data }) {
  const { questionId } = useParams();
  const question = data.find((el) => el.questionId === parseInt(questionId));
  // params와 일치하는 id 값을 찾아서, 내용 작성

  return (
    <Container>
      <div className="top">
        <ItemTop data={data} />
        <Link to={"/question/ask"}>
          <AddAsk />
        </Link>
      </div>
      <div className="bottom">
        <ItemContainer>
          <div className="flex-style">
            <ItemLeft data={data} />
            <ItemContent data={data} />
          </div>
          <ToastEditor />
        </ItemContainer>
        <SideBar />
      </div>
    </Container>
  );
}

const Container = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 50px;
  width: calc(100% - 164px);
  max-width: 1100px;
  padding: calc(24px * 1);

  > .top {
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: start;
    border-bottom: solid 1px ${({ theme }) => theme.black100};
    padding-bottom: 8px;

    > a {
      text-decoration: none;
    }
  }

  > .bottom {
    display: flex;
    padding-top: 16px;
  }
`;

const ItemContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: calc(100% - 300px);

  > .flex-style {
    display: flex;
  }
`;
