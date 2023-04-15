import React from "react";
import styled from "styled-components";

export default function Article5() {
  return (
    <Container>
      <div className="title">
        Collectives <span>see all</span>
      </div>
      <div className="box1">
        <div className="top">
          <div className="left">
            <img
              src="https://cdn.sstatic.net/Sites/stackoverflow/Img/subcommunities/aws.svg?v=46d86cbff922"
              alt="img"
            />
            <div className="linkTitle">
              <span>AWS</span>
              <span>10k Members</span>
            </div>
          </div>
          <Btn>Join</Btn>
        </div>
        <div className="bottom">
          Amazon Web Services (AWS) is the world’s most comprehensive and
          broadly adopted cloud platform, offering over 200 fully featured
          services from data centers globally. The AWS Collective is a
          community-driven site with resources for developers.
        </div>
      </div>
      <div className="box1">
        <div className="top">
          <div className="left">
            <img
              src="https://cdn.sstatic.net/Sites/stackoverflow/Img/subcommunities/azure.svg?v=acd37945b78d"
              alt="img"
            />
            <div className="linkTitle">
              <span>Microsoft Azure</span>
              <span>6k Members</span>
            </div>
          </div>
          <Btn>Join</Btn>
        </div>
        <div className="bottom">
          On-premises, hybrid, multicloud, or at the edge—build on your terms
          with best-in-class tools, your favorite open-source frameworks and
          languages, and a platform that supports continuous collaboration and
          delivery with Azure.
        </div>
      </div>
      <div className="box1">
        <div className="top">
          <div className="left">
            <img
              src="https://cdn.sstatic.net/Sites/stackoverflow/Img/subcommunities/r-language.svg?v=284038a37d38"
              alt="img"
            />
            <div className="linkTitle">
              <span>R Language</span>
              <span>2k Members</span>
            </div>
          </div>
          <Btn>Join</Btn>
        </div>
        <div className="bottom">
          A collective where data scientists and AI researchers gather to find,
          share, and learn about R and other subtags like knitr and dplyr.
        </div>
      </div>
    </Container>
  );
}

const Container = styled.div`
  width: 100%;
  margin-bottom: 16px;
  border: 1px solid ${({ theme }) => theme.black100};
  border-radius: 3px;
  box-shadow: 0 10px 24px hsla(0, 0%, 0%, 0.05),
    0 20px 48px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.1);

  > .title {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: ${({ theme }) => theme.black025};
    color: ${({ theme }) => theme.black600};
    padding: 12px 16px;

    > span {
      font-size: 12px;
      color: ${({ theme }) => theme.blue600};
    }
  }

  > .box1 {
    display: flex;
    flex-direction: column;
    padding: 16px 15px;
    border-bottom: solid 1px ${({ theme }) => theme.black100};

    > .top {
      display: flex;
      justify-content: space-between;
      width: 100%;
      margin-bottom: 15px;

      > .left {
        display: flex;

        > img {
          width: 40px;
          height: 40px;
          margin-right: 12px;
          border-radius: 7px;
        }

        > .linkTitle {
          display: flex;
          flex-direction: column;

          > span:nth-child(1) {
            color: ${({ theme }) => theme.black500};
          }

          > span:nth-child(2) {
            font-size: 12px;
            color: ${({ theme }) => theme.black700};
          }
        }
      }
    }

    > .bottom {
      color: ${({ theme }) => theme.black700};
      font-size: 13px;
      overflow: hidden;
      display: -webkit-box;
      -webkit-line-clamp: 2;
      -webkit-box-orient: vertical;
    }
  }
`;

const Btn = styled.div`
  border: ${({ theme }) => theme.powder500} solid 1px;
  color: ${({ theme }) => theme.blue500};
  padding: 9px;
  border-radius: 3px;
  font-size: 12px;
`;
