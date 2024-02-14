import axios from "axios";
import { useEffect, useState } from "react";

const List = () => {
  const [list, setList] = useState([]);

  useEffect(() => {
    const getList = async () => {
      try {
        const response = await axios.get('//localhost:8080/api/post/list');
        setList(response.data); // 서버에서 받은 데이터를 상태에 설정
      } catch (error) {
        console.error('Error fetching post list:', error);
      }
    };

    getList(); // 컴포넌트가 마운트될 때 게시글 목록을 가져오는 함수 호출
  }, []); // 빈 배열을 두어 한 번만 호출되도록 설정

  return (
    <div className="overflow-x-auto">
      <table className="table">
        {/* 테이블 헤더 */}
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
          </tr>
        </thead>
        <tbody>
          {list.map((post) => (
            <tr key={post.id}>
              <td>{post.id}</td>
              <td>{post.title}</td>
              <td>{post.content}</td>
              <td>{post.createdDate}</td>
              <td>{post.member.userName}</td>
              <td>{post.member.nickName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default List;
