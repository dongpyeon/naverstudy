//map반복문, slice, filter
let array=["red","green","blue","pink","orange","gray"];
//map을 이용해서 출력하기
array.map((color,idx)=>console.log(idx+":"+color));
console.log("---------------------------------------------------------------------------");
//배열의 데이타 잘라내기(slice), 걸러내기(filter)
//blue를 삭제 후 다시 출력
array1=[...array.slice(0,2),
        ...array.slice(3,array.length)];
array.map((color,idx)=>console.log(idx+":"+color));


console.log("--------여기서 부터는 필터 -------------------");
let array2=array.filter((color,idx)=>idx!==2) //i가 2가 아닌것만 리턴(필터링)
array2.map((color,idx)=>console.log(idx+":"+color));