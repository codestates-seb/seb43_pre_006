import React from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import AddAsk from "./../Top/AddAsk";
import SideBar from "./../../SideBar/SideBar";
import ItemContent from "./Content/ItemContent";
import ItemTop from "./Content/ItemTop";
import ItemLeft from "./Content/ItemLeft";

export default function QuestionItem({ data }) {
  const { questionId } = useParams();
  const question = data.find((el) => el.questionId === parseInt(questionId));
  // params와 일치하는 id 값을 찾아서, 내용 작성
  console.log(question);

  return (
    <Container>
      <div className="top">
        <ItemTop data={data} />
        <AddAsk />
      </div>
      <div className="bottom">
        <ItemContainer>
          <ItemLeft data={data} />
          <ItemContent data={data} />
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
  }

  > .bottom {
    display: flex;
    width: 100%;
    padding-top: 16px;
    justify-content: space-between;
  }
`;

const ItemContainer = styled.div`
  display: flex;
`;
