import styled from '@emotion/styled';

export const modalStyles: { content: React.CSSProperties } = {
  content: {
    top: '50%',
    left: '50%',
    right: 'auto',
    bottom: 'auto',
    marginRight: '-50%',
    transform: 'translate(-50%, -50%)',
    padding: 0,
  },
};

export const AskModalBlock = styled.div`
  width: 500px;
  background: #000824;
  color: #fefefe;
`;

export const TopBar = styled.div`
  display: flex;
  padding: 0.5rem;
  justify-content: flex-end;
  background: #002687;
  margin-bottom: 2rem;

  .anticon {
    margin-left: auto;
    color: #fff;
    font-size: 1.5rem;
    cursor: pointer;
  }
`;

export const Box = styled.div`
  width: 200px;
  height: 160px;
  background: #fff;
  margin: 0 auto;
  margin-bottom: 2rem;
  border-radius: 1rem;
`;

export const Meta = styled.div`
  width: fit-content;
  margin: 0 auto;
  margin-bottom: 0.5rem;

  span:first-of-type {
    margin-right: 1rem;
    font-size: 20px;
  }
`;

export const ButtonGroup = styled.div`
  width: fit-content;
  margin: 0 auto;
  margin-top: 1rem;
`;

interface ButtonProps {
  marginRight?: boolean;
  marginAuto?: boolean;
}

export const Button = styled.button<ButtonProps>`
  width: 5rem;
  height: 3rem;
  border-radius: 0.5rem;
  margin-bottom: 2rem;
  margin-right: ${({ marginRight }) => marginRight && '12px'};
  margin: ${({ marginAuto }) => marginAuto && '0 auto'};

  background: #1e0d86;
  border: 1px solid #1e0d86;
  font-size: 1rem;

  &:hover {
    background: #1e0d86;
    border: 1px solid #1e0d86;
  }
`;

export const ConfirmDialog = styled.div`
  display: flex;
  flex-direction: column;
  padding-bottom: 2rem;
`;

export const ConfirmText = styled.span`
  margin-bottom: 2rem;
  text-align: center;
`;