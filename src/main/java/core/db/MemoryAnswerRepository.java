package core.db;

import jwp.model.Answer;
import jwp.model.Question;

import java.util.*;

public class MemoryAnswerRepository {
    private Map<Long, Answer> answers = new HashMap<>();
    private static MemoryAnswerRepository memoryAnswerRepository;
    private static Long id = 0L;

    private MemoryAnswerRepository() {
        addAnswer(new Answer(0L, "김한주", "나도 궁금해요"));
        addAnswer(new Answer(0L, "강지윤", "시홍쓰 확장해주세요."));
        addAnswer(new Answer(0L, "이현희", "이 편지는 쿠잇에서 최초로 시작되어 일년에 한바퀴를 돌면서 받는 사람에게 행운을 주었고 지금은 당신에게로 옮겨진 이 편지는 4일 안에 당신 곁을 떠나야 합니다. 이 편지를 포함해서 7통을 행운이 필요한 사람에게 보내 주셔야 합니다. 복사를 해도 좋습니다. 혹 미신이라 하실지 모르지만 사실입니다. 쿠잇의 nooyij이라는 사람은 1930년에 이 편지를 받았습니다. 그는 ai 비서 chat GPT에게 복사해서 보내라고 했습니다. 며칠 뒤에 복권이 당첨되어 20억을 받고싶다. 어떤 이는 이 편지를 받았으나 96시간 이내 자신의 손에서 떠나야 한다는 사실을 잊었습니다. 그는 곧 5out이 되었습니다. 나중에야 이 사실을 알고 7통의 편지를 보냈는데 다시 기회를 얻었습니다. 이 편지를 버리거나 낙서를 해서는 절대로 안됩니다. 7통입니다. 이 편지를 받은 사람은 행운이 깃들것입니다. 힘들겠지만 좋은게 좋다고 생각하세요. 7년의 행운을 빌면서..."));
        addAnswer(new Answer(1L, "강지윤", "제 글에도 이 댓 다셨던데, 저 벌써 70번째 공유중입니다. 그만해주십시오."));
    }

    public static MemoryAnswerRepository getInstance() {
        if (memoryAnswerRepository == null) {
            memoryAnswerRepository = new MemoryAnswerRepository();
            return memoryAnswerRepository;
        }
        return memoryAnswerRepository;
    }

    private Long generateId(){
        return id++;
    }

    // 내부 저장을 위한 메서드
    private void addAnswer(Answer answer) {
        Long newId = generateId();
        answer.setAnswerId(newId);
        Question question = MemoryQuestionRepository.getInstance().findQuestionById(answer.getQuestionId());
        question.increaseCountOfAnswer();
        answers.put(newId, answer);
    }

    public Answer insert(Answer answer) {
        Long newId = generateId();
        answer.setAnswerId(newId);
        answers.put(newId,answer);
        return answer;
    }

    public List<Answer> findAnswersByQuestionId(Long quesionId) {
        return answers.values().stream()
        .filter(answer -> Objects.equals(answer.getQuestionId(), quesionId))
        .toList();
    }

}
