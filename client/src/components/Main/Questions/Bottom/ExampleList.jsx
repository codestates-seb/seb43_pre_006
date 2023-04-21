export const List = {
  data: [
    {
      questionId: 2,
      title: "제목입니다2",
      content:
        "In my rails app, I have a Shoryuken runner as a runner on a Kubernetes Stack.I have some long running job, and I want to do some action when the worker pod is stopped.As far as I know, Kubernetes send a SIGTERM to the worker. I wish to catch this SIGTERM in my job to, for instance, retry the running job. But it seems that the signal cannot be catch in the job.Any idea?",
      createdAt: "2023-01-02T14:33:31.517606",
      modifiedAt: "2023-01-02T14:33:31.517606",
      score: 0,
      viewCount: 0,
      userName: "kimcodingding",
      userEmail: "kcdd@gmail.com",
      answers: [],
    },
    {
      questionId: 1,
      title: "제목입니다",
      content: "안에 있는 내용입니다2.",
      createdAt: "2023-01-02T14:33:10.7882",
      modifiedAt: "2023-01-02T14:33:10.7882",
      score: 0,
      viewCount: 1,
      userName: "kimcodingding",
      userEmail: "kcdd@gmail.com",
      answers: [],
    },
  ],
  pageInfo: {
    page: 1,
    size: 10,
    totalElements: 2,
    totalPages: 1,
  },
};
